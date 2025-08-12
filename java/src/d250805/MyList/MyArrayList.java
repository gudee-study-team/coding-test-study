package d250805.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E>{
    private Object[] array;
    private int cur=0,size=20;

    //기본 생성자일 경우 
    public MyArrayList(){
        this.array=new Object[size];
    }
    //크기를 줄때
    public MyArrayList(int x){ 
        if(x>=0){
            this.array=new Object[x];
        }else{
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
    }
    //새로운 배열을 생성해서 복사하고 크기를 키움
    public void resizing(){
        Object[]copyArray= Arrays.copyOf(this.array, this.array.length+size);
        this.array=copyArray;
    }
    //cur이 저장된 인덱스의 다음을 가리킴
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
        if(this.array.length==cur){
                resizing();
            }
        if(index==cur){
            this.array[index]=value;
            cur++;
        }else if(index<0||index>cur){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            //배열 끝부분 부터 특정Index까지 반복문을 돌려서 한칸씩 뒤로 값을 이동시킴
            for(int i = cur; i>index ;i--){
                this.array[i]=this.array[i-1];
            }
            this.array[index]=value;
            cur++;
        }
        
    }

    //새로운 배열을 만들어줌
    @Override
    public void clear() {
        this.array=new Object[size];
        cur=0;
    }

    @Override
    public boolean contains(Object value) {
        boolean exist=false;
        for(int i=0; i<cur; i++){
            
            if(this.array[i]==null?this.array[i]==value:this.array[i].equals(value)){
                exist=true;
                break;
            }
        }
        return exist;
    }

    //index가 음수거나 배열 길이보다 크면 예외 발생시킴
    @Override
    public E get(int index) {
        if(index<0 || index>=cur){
            throw new ArrayIndexOutOfBoundsException();
        }
        E result = (E)this.array[index];
        
        return result;
    }
    @Override
    public int indexOf(Object value) {
        int index=-1;
        for(int i=0; i<cur; i++){
            if(this.array[i]==null?this.array[i]==value:this.array[i].equals(value)){
                index=i;
                break;
            }
        }
        return index;
    }
    @Override
    public boolean isEmpty() {
        if(cur==0){
            return true;
        }
        return false;
    }
    @Override
    public int lastIndexOf(Object value) {
        int index=-1;
        for(int i=cur-1; i>=0; i--){
            if(this.array[i]==null?this.array[i]==value:this.array[i].equals(value)){
                index=i;
                break;
            }
        }
        return index;
    }
    @Override
    public E remove(int index) {
        Object result=null;
        if(index<0||cur==0||index>=cur){
            throw new ArrayIndexOutOfBoundsException();

        }
        else if(index==cur-1){
        result=this.array[index];
            this.array[index]=null;
            cur--;
        }else{
            result=this.array[index];
            //삭제된 Index부터 배열 끝까지 반복문을 돌려서 한칸씩 앞으로 값을 이동시킴
            for(int i = index; i<cur ;i++){
                //반복문을 돌릴때 배열크기를 넘어가는 인덱스를 참조하려는것을 방지
                if(i==cur-1){
                    this.array[i]=null;
                    break;
                }
            
                this.array[i]=this.array[i+1];
            }
            cur--;
        }
        return (E)result;
    }
    @Override
    public boolean remove(Object value) {
        boolean exist=false;
        int i=0;
        for( ; i<cur; i++){
            if(this.array[i]==null?this.array[i]==value:this.array[i].equals(value)){
                exist=true;
                break;
            }
        }
        if(exist){
            remove(i);
        }
        return exist;
    }
    @Override
    public void set(int index, Object value) {
        if(index>=0 && index<cur)
        this.array[index]=value;
        else{
            throw new ArrayIndexOutOfBoundsException();
        }

        
    }@Override
    public int size() {
        return cur;
    }
    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

}
