package d250805.MyList;

import java.util.Arrays;

public class MyArrayaList<E> implements MyList<E>{
    private Object[] array;
    private int cur=0,size=20;

    //기본 생성자일 경우 
    public MyArrayaList(){
        this.array=new Object[size];
    }
    //크기를 줄때
    MyArrayaList(int x){ 
        if(x>0){
            this.array=new Object[x];
        }else if(x==0){
            this.array=new Object[size];
        }else{
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
    }
    //새로운 배열을 생성해서 복사하고 크기를 키움
    public void resizing(){
        Object[]copyArray= Arrays.copyOf(this.array, this.array.length+size);
        this.array=copyArray;
    }
    @Override
    public boolean add(Object value) {
        if(this.array.length==cur){
            resizing();
        }
        array[cur]=value;
        cur++;
        return true;
    }
    @Override
    public void add(int index, Object value) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public boolean contains(Object value) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int indexOf(Object value) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean remove(Object value) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void set(int index, Object value) {
        // TODO Auto-generated method stub
        
    }@Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
