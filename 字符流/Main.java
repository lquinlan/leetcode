public class Main{
    public static void main(String[] args) {
        
    }
}

class StreamChecker {
    class Tire{
        Tire[] childs=new Tire[26];
        boolean done=false;
        
    }
    Tire root=new Tire();
    int Maxlen=0;


    public StreamChecker(String[] words) {
        for(String word : words){
            Maxlen=Math.max(Maxlen,word.length());
            creatTree(word);
        }

    }
    void creatTree(String word){
        Tire tmp=root;
        int len=word.length();
        for(int i = 0; i < len; i++){
            char tmpchar=word.charAt(len-i-1);
            if(tmp.childs[tmpchar-'a']==null){
                tmp.childs[tmpchar - 'a'] = new Tire();
            }
            tmp=tmp.childs[tmpchar - 'a'];

        }
        tmp.done=true;
    }
    boolean find(StringBuilder str){
        int len=str.length();

        Tire tmp=root;
        for(int i=0;i<len&&i<Maxlen;++i){
            if(tmp.done==true){
                return true;
            }
            char tmpchar=str.charAt(len-i-1);
            if(tmp.childs[tmpchar-'a']==null){
                return false;
            }
            
            tmp=tmp.childs[tmpchar - 'a'];
           

        }
        return tmp.done;

    }
    StringBuilder str = new StringBuilder();
    
    public boolean query(char letter) {
        str.append(letter);
        return find(str);

    }
}