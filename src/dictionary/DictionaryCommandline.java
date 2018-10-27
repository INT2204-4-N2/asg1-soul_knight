package dictionary;

import java.util.ArrayList;

public class DictionaryCommandline extends DictionaryManagement{

    public  Dictionary listOfAll;
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    ArrayList<Word> arrays =new ArrayList<Word>();


    public void showAllWords(Dictionary vd) {

        arrays = vd.getWords();
        System.out.println("stt  " +"|English  "+"|Tiếng việt");
        for (int i = 0; i < arrays.size(); i++) {
            System.out.println((i+1) + "     |" + arrays.get(i).getWord_target() + "    |"+ arrays.get(i).getWord_explain());
        }
    }
    public void dictionaryBasic() {
        DictionaryManagement a =new DictionaryManagement();
        Dictionary b = new Dictionary();
        DictionaryCommandline c = new DictionaryCommandline();
        b.setWords(a.insertFromcomandline());
        c.showAllWords(b);
    }
    public void dictionaryAdvanced()
    {
        DictionaryManagement a =new DictionaryManagement();
        Dictionary b = new Dictionary();
        DictionaryCommandline c = new DictionaryCommandline();
        a.insertFromFile();
        c.showAllWords(b);
       // a.dictionaryLookup();

    }
    public void Menu(){
        System.out.println();
        System.out.println("************Dictionary************");
        System.out.println("1.Tra từ ");
        System.out.println("2.Thêm từ mới ");
        System.out.println("3.Thêm từ vào File ");
        System.out.println("Nhập lựa chọn của bạn:");
        dictionaryManagement.DictionarySelection();
        this.Menu();
    }
    public ArrayList<String> dictionarySearcher(String a){
        ArrayList<String> ADD = new ArrayList<>();
        for (int i=0;i<dictionaryManagement.result.size();i++){
            if(dictionaryManagement.result.get(i).getWord_target().startsWith(a))
                ADD.add(dictionaryManagement.result.get(i).getWord_target());
        }
        return ADD;
    }
    public ArrayList<String> dictionaryDelete(String a){
        ArrayList<String> ADD = new ArrayList<>();
        for (int i=0;i<dictionaryManagement.result.size();i++){
            if(dictionaryManagement.result.get(i).getWord_target().startsWith(a))
                ADD.remove(dictionaryManagement.result.get(i).getWord_target());
        }
        return ADD;
    }

}
