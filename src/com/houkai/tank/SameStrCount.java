package com.houkai.tank;


public class SameStrCount {

	public static void main(String[] args) {
		String str="asjdudhhhhyyyyya";
		int min=1;
		int temp=0;
		char ch='0';
		char[]strArr=str.toCharArray();
		for (int i = 0; i < strArr.length-1; i++) {
			System.out.println(strArr[i]);
			if (strArr[i]==strArr[i+1]) {
				//如果相邻的两个字符相等,min+1,与temp比较
				min+=1;
				if (min>temp) {
					ch=strArr[i];
					temp=min;
				}else if(min==temp){
					
				}
			}else {
				//如果不相等,赋默认值
				min=1;
			}
		}
		System.out.println("最大连续字符为: "+ch+" 出现次数为: "+temp);
	}
}
