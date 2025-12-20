
// package com.example.demo.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "farms")
// public class Farm {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "owner_id", nullable = false)
//     private User owner;

//     @Column(nullable = false)
//     private String name;

//     @Column(nullable = false)
//     private Double soilPH;

//     @Column(nullable = false)
//     private Double waterLevel;

//     @Column(nullable = false)
//     private String season;

//     public Farm() {
//     }

//     public Farm(User owner, String name, Double soilPH, Double waterLevel, String season) {
//         this.owner = owner;
//         this.name = name;
//         setSoilPH(soilPH);
//         this.waterLevel = waterLevel;
//         setSeason(season); 
//     }
//     public Farm(Long id, User owner, String name, Double soilPH, Double waterLevel, String season) {
//         this.id = id;
//         this.owner = owner;
//         this.name = name;
//         setSoilPH(soilPH);   
//         this.waterLevel = waterLevel;
//         setSeason(season);   
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public User getOwner() {
//         return owner;
//     }

//     public void setOwner(User owner) {
//         this.owner = owner;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Double getSoilPH() {
//         return soilPH;
//     }

//     public void setSoilPH(Double soilPH) {
//         if (soilPH == null || soilPH < 3.0 || soilPH > 10.0) {
//             throw new IllegalArgumentException("Invalid pH value. pH must be between 3 and 10.");
//         }
//         this.soilPH = soilPH;
//     }

//     public Double getWaterLevel() {
//         return waterLevel;
//     }

//     public void setWaterLevel(Double waterLevel) {
//         this.waterLevel = waterLevel;
//     }

//     public String getSeason() {
//         return season;
//     }

//     public void setSeason(String season) {
//         if (season == null ||
//             !(season.equalsIgnoreCase("Kharif") ||
//               season.equalsIgnoreCase("Rabi") ||
//               season.equalsIgnoreCase("Summer"))) {

//             throw new IllegalArgumentException(
//                 "Invalid season. Allowed values: Kharif, Rabi, Summer"
//             );
//         }
//         this.season = season;
//     }
// }


package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String name;

    private Double soilPH;

    private Double waterLevel;

    private String season;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private List<Suggestion> suggestions;

    public Farm(User owner, String name, Double soilPH, Double waterLevel, String season) {
        this.owner = owner;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }
}
