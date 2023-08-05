package baitapmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KhoiTaoTreeMap {
    public static void main(String[] args) {
        // khai bao 1 tree map co ten la map 1
        // co key la string va value la string
        TreeMap<String,String> treeMap = new TreeMap<String,String>();
        // them cac phan tu vao tree map
        treeMap.put("1","Mot");
        treeMap.put("2","Hai");
        treeMap.put("3","Ba");
        treeMap.put("4","Bon");
        System.out.println(treeMap.get("1"));

//        print(treeMap);
        // su dung Map.Entry interface de duyet cac phan tu cua Tree Map
//        for(Map.Entry<String,String>  entry: treeMap.entrySet()){
//            System.out.println(entry.getKey()+" - "+entry.getValue());
//        }
        //Su dung itorator de duyet cac phan tu cuaa map
//        Iterator<String> iterator= treeMap.keySet().iterator();
//        while (iterator.hasNext()){
//            System.out.println(treeMap.get(iterator.next()));
//        }
        //truy cap phan tu cua tree map
//        System.out.println("Truy cap phan tu thu nhat: "+treeMap.get("1"));
//        System.out.println("Truy cap phan tu thu hai: "+treeMap.get("2"));
        // cap nhat gia tri cua phan tu tree map
//        System.out.println(treeMap);
//        treeMap.put("1","Nam");
//        System.out.println(treeMap);
        // xoa phan tu cua tree map
//        System.out.println(treeMap);
//        treeMap.remove("1");
//        System.out.println(treeMap);
        // xoa tat ca cac phan tu cua tree map
//        System.out.println(treeMap);
//        treeMap.clear();
//        System.out.println(treeMap);

    }
    // duyet cac phan tu cua tree map
    public static void print(Map<String,String> map){
        Set<String> keySet = map.keySet();
        for(String key: keySet){
            System.out.println(key+" - "+ map.get(key));
        }

    }
}
