package leetcode.hard;
import java.util.HashMap;
import java.util.Map;
public class MinimumWindowSubstring {
	class SlideWindow{
		public int left = 0;
		public int length = 0;	
		public int leftMin = 0;
		public int lengthMin = Integer.MAX_VALUE;
	}	
    public String minWindow(String s, String t) {
    	SlideWindow sw = new SlideWindow();
    	//记录t字符里面出现的轮次
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	//记录t字符串里面的所有关于字符与出现次数的信息
    	Map<Character,Integer> countMap = new HashMap<Character,Integer>();
    	//记录t字符里面出现的轮次，不过用在left的处理里面
    	Map<Character,Integer> revMap = new HashMap<Character,Integer>();
    	//标记是否已经完成了一次全部匹配
//    	boolean flag = false;
    	//标记当前已经匹配的字符长度
    	int matchCount = 0;
    	//标记当前已经匹配的字符长度，不过用在left的处理里面
    	int revMatchCount = 0;
    	boolean flag = false;
    	//当前正在找窗口的编号，从1开始
    	int windowNum = 1;
    	for(int i=0;i<t.length();i++){
    		map.put(t.charAt(i), 0);
    		revMap.put(t.charAt(i), 0);
    		if( countMap.containsKey(t.charAt(i)) ){
    			countMap.put(t.charAt(i), countMap.get(t.charAt(i))+1);
    		}else{
    			countMap.put(t.charAt(i), 1);
    		}
    	}
    	for(int i=0;i<s.length();i++){
    		System.out.print(s.charAt(i)+"  "+map.containsKey(s.charAt(i))+"\n");
    		//如果当前字符是在t里面
    		if(map.containsKey(s.charAt(i)) ){
    			//如果在第n轮里面第一次遇到t的字符
//    			if( matchCount == 0 ){
//    				System.out.println("第"+windowNum+"轮 sw.left:"+i);
//    				sw.left = i;
//    			}
    			//遇到新的字符
    			//map.get(s.charAt(i)) < countMap.get(s.charAt(i)) * windowNum
    			if( map.get(s.charAt(i)) < countMap.get(s.charAt(i)) ){
    				matchCount++;
    				map.put(s.charAt(i), map.get(s.charAt(i))+1);
    			}
    		}
    		System.out.println("matchCount:"+matchCount+" i:"+i);
    		//如果已经全部遇到一次了，才需要记录最短长度窗口和移动窗口
    		if( matchCount == t.length() ){ //这里如果遇到t有相同字符的，是处理不了的，需要多加一个map记录每个字符的次数
    			System.out.println(i);
    			sw.length = i-sw.left+1;    
    			//找到了更小的窗口
    			if( sw.lengthMin > sw.length ){
    				System.out.println("更新 sw.lengthMin:"+sw.lengthMin+" sw.length:"+sw.length+" sw.left:"+sw.left);
    				sw.leftMin = sw.left;
    				sw.lengthMin = sw.length;
    			}    	
    			//这个left的更新有问题，要在第一次遇到t的字符的时候才可以处理
//    			sw.left = i+1;
    			matchCount = 0;    			
    			//进入下一次寻找
    			windowNum++;
    			//left处理
    			revMatchCount = 0;
    			for(int k=0;k<t.length();k++){
    				revMap.put(t.charAt(k), 0);
    			}
    			flag = false;
    			//这里要做left的处理，找出里面的最短的[sw.left+1...right/i]，然后再移动left
    			for(int j=i;j>=sw.left+1;j--){
    				System.out.println("j:"+j);
    				if( revMap.containsKey(s.charAt(j)) ){
    					if( revMap.get(s.charAt(j)) < countMap.get(s.charAt(j)) ){
    						revMatchCount++;
    						revMap.put(s.charAt(j), revMap.get(s.charAt(j))+1);
    					}    					
    				}
    				if( revMatchCount == t.length() ){
    					System.out.println("bingo");
    					flag = true;
    					//更新
    					if( sw.lengthMin > i-j+1 ){
    						sw.lengthMin = i-j+1;
    						sw.leftMin = j;
    					}
    					sw.left = j+1;
    					break;
    				}
    				System.out.println("sw.left:"+sw.left);
    			}
    			if( flag == false ){
    				System.out.println("move");
    				sw.left++;
    			}
    			//reset
    			for(int k=0;k<t.length();k++){
    				map.put(t.charAt(k), 0);
    			} 
    			map.put(s.charAt(i), 1);
    			matchCount++;
    		}
    		sw.length = i-sw.left+1;    		
    	}
    	System.out.print("sw.leftMin:"+sw.leftMin+"\n");
    	System.out.print("sw.lengthMin:"+sw.lengthMin+"\n");
    	//如果还是在第一轮的话，就是没有找到东西
    	if( windowNum == 1 ){
    		return "";
    	}
        return s.substring(sw.leftMin, sw.leftMin+sw.lengthMin);
    }
    /**
     * 这个是discussion的版本
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	int start = 0,end = 0,minStart = 0,minLength = Integer.MAX_VALUE,count = t.length();
    	for(int i=0;i<t.length();i++){
    		if( map.containsKey(t.charAt(i)) ){
    			map.put(t.charAt(i), map.get(t.charAt(i))+1);
    		}else{
    			map.put(t.charAt(i), 1);
    		}
    	}       	
    	while( end < s.length() ){
    		if( map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) > 0 ){
    			count--;
    		}
    		if( map.containsKey(s.charAt(end)) ){
    			//走过的路-1
    			map.put(s.charAt(end), map.get(s.charAt(end))-1);
    		}else{
    			map.put(s.charAt(end), -1);
    		}
    		end++;
    		//发现一个符合条件的字符串
    		while( count == 0 ){
    			//更新记录，因为这里end已经被+1了，所以这里的不用在+1了
    			if( minLength > end-start ){
    				minLength = end-start;
    				minStart = start;
    			}    			
    			map.put(s.charAt(start), map.get(s.charAt(start))+1);    		
    			//判断是否找到了合适的start
    			if( map.get(s.charAt(start)) > 0 ){
    				count++;
    			}
    			start++;
    		}
    	}
//    	System.out.println("minStart:"+minStart);
//    	System.out.println("minLength:"+minLength);
    	if( minLength!=Integer.MAX_VALUE ){
    		return s.substring(minStart, minStart+minLength);
    	}
    	return "";
    }
    /**
     * 如果输入s和t同时都是aa的话，会出问题，问题在于t里面包含了一样的字符
     * @param args
     */
    public static void main(String[] args) {
    	MinimumWindowSubstring obj = new MinimumWindowSubstring();
    	//BANC
//    	String s = "ADOBECODEBANC",t = "ABC";
//    	String s = "aa",t = "aa";
    	String s = "bdab",t = "ab"; // out:bda expect:ab
    	String result = obj.minWindow2(s, t);
    	System.out.print(result);
    }
}
