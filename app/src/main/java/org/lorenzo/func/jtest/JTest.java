package org.lorenzo.func.jtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Shuo on 2023-07-25
 * <p>
 */
public class JTest {
    @Test
    public void genericSample() {
        List<JCat> aList = new ArrayList<>();
//        join1(aList);

        ArrayList<JCat> bList = new ArrayList<>();
//        join1(bList);
        join2(bList);
        join3(bList);
        join4(bList);

        ArrayList<JAnimal> cList = new ArrayList<>();
        join4(cList);
    }

    @Test
    // 生产者-协变.
    public void genericSample2() {
        ArrayList<? extends JAnimal> a1List = new ArrayList<>();
        ArrayList<? extends JAnimal> a2List = new ArrayList<JCat>();
        ArrayList<? extends JAnimal> a3List = new ArrayList<JKetty>();

//        // 写.
//        a1List.add(new JAnimal());
//        a1List.add(new JCat());
//        a1List.add(new JKetty());
//
//        a2List.add(new JAnimal());
//        a2List.add(new JCat());
//        a2List.add(new JKetty());
//
//        a3List.add(new JAnimal());
//        a3List.add(new JCat());
//        a3List.add(new JKetty());
//
//        // 读.
//        ArrayList<JCat> catList = new ArrayList<>();
//        catList.add(new JCat());
//        a1List = catList;
//        JAnimal animal = a1List.get(0);
//        JCat cat = (JCat) a1List.get(0);
//        System.out.println(animal);
//        System.out.println(cat);
    }

    @Test
    // 消费者-逆变.
    public void genericSample3() {
        ArrayList<? super JKetty> a1List = new ArrayList<>();
        ArrayList<? super JCat> a2List = new ArrayList<>();
        ArrayList<? super JAnimal> a3List = new ArrayList<>();

//        // 写.
//        a1List.add(new JAnimal());
//        a1List.add(new JCat());
//        a1List.add(new JKetty());
//
//        a2List.add(new JAnimal());
//        a2List.add(new JCat());
//        a2List.add(new JKetty());
//
//        a3List.add(new JAnimal());
//        a3List.add(new JCat());
//        a3List.add(new JKetty());
//
//        // 读.
//        Object obj1 = a1List.get(0);
//        Object obj2 = a2List.get(0);
//        Object obj3 = a3List.get(0);
    }

    private void join1(List<JAnimal> data) {

    }

    public void join2(List<JCat> data) {

    }

    public void join3(List<? extends JAnimal> data) {

    }

    public void join4(List<? super JCat> data) {

    }

    /**
     * Remember PECS: "Producer Extends, Consumer Super".
     * "Producer Extends" - If you need a List to produce T values 【you want to read Ts from the list】,
     * you need to declare it with ? extends T, e.g. List<? extends Integer>. But you cannot add to this list.
     * "Consumer Super" - If you need a List to consume T values 【you want to write Ts into the list】,
     * you need to declare it with ? super T, e.g. List<? super Integer>.
     * But there are no guarantees what type of object you may read from this list.
     * If you need to both read from and write to a list, you need to declare it exactly with no wildcards, e.g. List<Integer>.
     */
    void toolFunction(){

    }
}
