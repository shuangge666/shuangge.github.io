package streamStudy;

import java.util.*;


/*求解文法所有产生式右部的First集*/
public class First {
    public Map<String,Set<String>>firstSet;//所有产生式右部的First集
    public Map<String,List<String>> map;//产生式集合
    public List<String>terminal;//终结符集合,只存储了文法中的非数字，数字也属于终结符

    public First() {
        this.map=new HashMap<>();
        List<String>list1=new ArrayList<>();
        list1.add("TX");
        map.put("E",list1);
        List<String>list2=new ArrayList<>();
        list2.add("+TX");
        list2.add("-TX");
        list2.add("^");
        map.put("X",list2);
        List<String>list3=new ArrayList<>();
        list3.add("FY");
        map.put("T",list3);
        List<String>list4=new ArrayList<>();
        list4.add("*FY");
        list4.add("/FY");
        list4.add("^");
        map.put("Y",list4);
        List<String>list5=new ArrayList<>();
        list5.add("(E)");
        list5.add("d");
        map.put("F",list5);
        this.firstSet=new HashMap<>();
        this.terminal=new ArrayList<>();
        this.terminal.add(String.valueOf('+'));
        this.terminal.add(String.valueOf('-'));
        this.terminal.add(String.valueOf('*'));
        this.terminal.add(String.valueOf('/'));
        this.terminal.add(String.valueOf('('));
        this.terminal.add(String.valueOf(')'));
        this.terminal.add(String.valueOf('d'));//d代表数字num
        this.terminal.add(String.valueOf('^'));//以^代表空
    }

    /*求解str的First集*/
    public void getFirst(){
        Set<Map.Entry<String, List<String>>> entries = this.map.entrySet();
        for(Map.Entry<String,List<String>>entry:entries){
            String left=entry.getKey();
            List<String>rights=entry.getValue();
            for(String gg:rights){//gg就是每个产生式的右部
                String product=left+"->"+gg;//产生式的字符串完整表达
                Set<String>ok=new HashSet<>();//该产生式右部的First集
                String firstChar=gg.substring(0,1);//右部首字母
                if(this.terminal.contains(firstChar)){//首字母是终结符
                    ok.add(firstChar);
                    continue;
                }
                Set<String> charFirstSet = getCharFirstSet(firstChar);//右部首字母的First集
                ok.addAll(charFirstSet);
//                this.firstSet.put(product,charFirstSet);
                if(charFirstSet.contains("^")){//第一个字符包含空，那么向后检查
                    int pos=1;
                    Set<String>z=getCharFirstSet(gg.substring(pos,pos+1));
                    ok.addAll(z);
                    ++pos;
                    while(pos<gg.length()&&!this.terminal.contains(gg.substring(pos,pos+1))
                            &&(z=getCharFirstSet(gg.substring(pos,pos+1))).contains("^")){
                        ok.addAll(z);
                        ++pos;
                    }
                }
                this.firstSet.put(product,ok);
            }
        }
    }

    //求解单个字符的First集
    public Set<String> getCharFirstSet(String ch){
        Set<String>ans=new HashSet<>();
        List<String> rights = map.get(ch);
        for(String str:rights){
            if(this.terminal.contains(str.substring(0,1))){
                ans.add(str.substring(0,1));
            }
            else{//产生式右部第一个字符是非终结符
                int pos=0;
                Set<String>k;
                k=getCharFirstSet(str.substring(pos,pos+1));
                ans.addAll(k);
                ++pos;
                if(k.contains("^")){
                    //当终结符的First集中含有空，那么一直往后，把非终结符的First都加入ans
                    while(pos<str.length()&&!this.terminal.contains(str.substring(pos,pos+1))
                            &&((k=getCharFirstSet(str.substring(pos,pos+1))).contains("^"))){
                        ans.addAll(k);
                        ++pos;
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        First ff=new First();
        ff.getFirst();
        System.out.println(ff.map.toString());
        System.out.println(ff.firstSet.toString());
    }

}
