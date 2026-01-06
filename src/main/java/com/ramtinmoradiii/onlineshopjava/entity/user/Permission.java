package com.ramtinmoradiii.onlineshopjava.entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"parent", "children"})
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Permission parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Permission> children = new ArrayList<>();

    public void addChild(Permission child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(Permission child) {
        children.remove(child);
        child.setParent(null);
    }
}
