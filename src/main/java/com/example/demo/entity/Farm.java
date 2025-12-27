package com.example.demo.entity; 
 
import jakarta.persistence.*; 
 
@Entity 
@Table(name = "farms") 
public class Farm { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
 
    @ManyToOne 
    @JoinColumn(name = "user_id") 
    private User owner; 
 
    private String name; 
    private Double soilPH; 
    private Double waterLevel; 
    private String season;
}