package com.ramtinmoradiii.onlineshopjava.entity.cms;

import com.ramtinmoradiii.onlineshopjava.entity.common.Attachment;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    private boolean enable = true;
    private Integer itemOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", nullable = false)
    private Attachment image;
}
