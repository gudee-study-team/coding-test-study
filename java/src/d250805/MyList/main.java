package d250805.MyList;

public class main {
    public static void main(String[] args) {
    MyArrayList<Number> list = new MyArrayList<>(); // 초기 capatity는 5

    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    list.add(4);

    list.add(1, 1.5); // 6번째 원소를 추가함으로서 리스트가 확장됨

    System.out.println(list); // [1, 1.5, 2, 2, 3, 4, null, null, null, null]

    System.out.println(list.indexOf(2)); // 2
    System.out.println(list.lastIndexOf(2)); // 3

    System.out.println(list.remove(0)); // 1
    System.out.println(list.remove(2)); // 2
    System.out.println(list); // [1.5, 2, 3, 4, null] - size에 비해 capacity가 남아돌아 리스트가 축소됨 (메모리 최적화)

    System.out.println(list.remove(Integer.valueOf(1))); // false
    System.out.println(list.remove(Integer.valueOf(2))); // true
    System.out.println(list); // [1.5, 3, 4, null, null]

    list.clear();
    System.out.println(list); // [null, null, null, null, null]
    }
}
