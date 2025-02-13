package javastreams.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamDemo {

   // @Test
    public void regular() {
        // Initialize list of names
        List<String> names = new ArrayList<>();
        names.add("Tony");
        names.add("Stark");
        names.add("Chris Evans");
        names.add("Thor");
        names.add("Hulk");

        System.out.println("Names List: " + names);

        int count = 0;

        for (String actual : names) {
            if (actual.contains("C")) {
                count++;
            }
            System.out.println("Current Count: " + count);
        }

        System.out.println("Final Count of names containing 'C': " + count);
    }
    
   // @Test
    public void streamFilter() {
    	List<String> names = new ArrayList<>();
        names.add("Tony");
        names.add("Stark");
        names.add("Chris Evans");
        names.add("Thor");
        names.add("Hulk");

        System.out.println("Names List: " + names);

        long index = names.stream().filter(n -> n.startsWith("H")).count();
        
        System.out.println(index);
        
        names.stream().filter(n -> n.length() > 4).forEach(s->System.out.println(s));
    	
    }
    
    //@Test
    public void streamMap() {
    	
    	List<String> marvel = Arrays.asList("Black Widow", "Hawk Eye", "Bucky");
    	
    	ArrayList<String> dc = new ArrayList<>();
    	dc.add("BatMan");
    	dc.add("Joker");
    	Stream.of("Tony Stark","Steve Rogers","Scarlet Witch", "Thanos").filter(s->s.endsWith("s"))
    																	.map(s->s.toUpperCase())
    																	.forEach(s->System.out.println(s));
    	
    	Stream.of("Superman","Wonder Woman","Aquaman", "Flash","Seoul").filter(s->s.startsWith("S"))
    																	.sorted()
    																	.map(s->s.toUpperCase())
    																	.forEach(s->System.out.println(s));
    	
    	
    	Stream<String> comics = Stream.concat(marvel.stream(),dc.stream());
    	//comics.sorted().forEach(c->System.out.println(c));
    	boolean flag = comics.anyMatch(s->s.equalsIgnoreCase("Joker"));
    	Assert.assertTrue(flag);
    	System.out.println(flag);
    	
    	
    }
    
    //@Test
    public void streamCollect() {
    	
    	List<String> marvelHeros = Stream.of("Tony Stark","Steve Rogers","Scarlet Witch", "Thanos")
																		.map(s->s.toUpperCase())
																		.collect(Collectors.toList());
    	System.out.println(marvelHeros.get(0));
    }
    @Test
    public void assignment() {
    	List<Integer> num = Arrays.asList(3,2,2,7,5,1,9,7);
    	
    	num.stream().distinct().forEach(n -> System.out.println(n));
    	
    	List<Integer> number = num.stream().distinct().sorted().collect(Collectors.toList());
    	
    	System.out.println(number.get(2));
    	
    	System.out.println("Test is Updated in clone Project in from QA");
    }
    
}

