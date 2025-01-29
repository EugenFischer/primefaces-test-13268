package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<TestObject> list;


    private TreeNode<String> root;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        list = new ArrayList<>(Arrays.asList(
            new TestObject("Thriller", "Michael Jackson", 1982),
            new TestObject("Back in Black", "AC/DC", 1980),
            new TestObject("The Bodyguard", "Whitney Houston", 1992),
            new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973)
        ));

        root = new DefaultTreeNode<>("Files", null);
        var node0 = new DefaultTreeNode<>("Documents", root);
        var node1 = new DefaultTreeNode<>("Events", root);
        var node2 = new DefaultTreeNode<>("Movies", root);

        var node00 = new DefaultTreeNode<>("Work", node0);
        var node01 = new DefaultTreeNode<>("Home", node0);

        node00.getChildren().add(new DefaultTreeNode<>("Expenses.doc"));
        node00.getChildren().add(new DefaultTreeNode<>("Resume.doc"));
        node01.getChildren().add(new DefaultTreeNode<>("Invoices.txt"));

        var node10 = new DefaultTreeNode<>("Meeting", node1);
        var node11 = new DefaultTreeNode<>("Product Launch", node1);
        var node12 = new DefaultTreeNode<>("Report Review", node1);

        var node20 = new DefaultTreeNode<>("Al Pacino", node2);
        var node21 = new DefaultTreeNode<>("Robert De Niro", node2);

        node20.getChildren().add(new DefaultTreeNode<>("Scarface"));
        node20.getChildren().add(new DefaultTreeNode<>("Serpico"));

        node21.getChildren().add(new DefaultTreeNode<>("Goodfellas"));
        node21.getChildren().add(new DefaultTreeNode<>("Untouchables"));
    }

}
