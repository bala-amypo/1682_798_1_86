// package com.example.demo.controller;

// import com.example.demo.dto.FarmRequest;
// import com.example.demo.entity.Farm;
// import com.example.demo.entity.User;
// import com.example.demo.service.FarmService;
// import com.example.demo.service.UserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/farms")
// @RequiredArgsConstructor
// public class FarmController {

//     private final FarmService farmService;
//     private final UserService userService;

//     @PostMapping
//     public ResponseEntity<?> createFarm(@RequestBody FarmRequest req, Authentication auth) {

//         User user = userService.findByEmail(auth.getName());

//         Farm farm = Farm.builder()
//                 .name(req.getName())
//                 .soilPH(req.getSoilPH())
//                 .waterLevel(req.getWaterLevel())
//                 .season(req.getSeason())
//                 .build();

//         return ResponseEntity.ok(
//                 farmService.createFarm(farm, user.getId())
//         );
//     }

//     @GetMapping
//     public ResponseEntity<?> listFarms(Authentication auth) {

//         User user = userService.findByEmail(auth.getName());

//         return ResponseEntity.ok(
//                 farmService.getFarmsByOwner(user.getId())
//         );
//     }

//     @GetMapping("/{farmId}")
//     public ResponseEntity<?> getFarm(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 farmService.getFarmById(farmId)
//         );
//     }
// }


// // package com.example.demo.controller;

// // import com.example.demo.dto.FarmRequest;
// // import com.example.demo.service.FarmService;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/farms")
// // @CrossOrigin
// // public class FarmController {

// //     @Autowired
// //     private FarmServiceImpl farmService;

// //     // POST /farms – add farm
// //     @PostMapping
// //     public ResponseEntity<?> createFarm(
// //             @RequestBody FarmRequest request,
// //             Authentication authentication) {

// //         return ResponseEntity.ok(
// //                 farmService.createFarm(request, authentication.getName())
// //         );
// //     }

// //     // GET /farms – list farms of logged-in user
// //     @GetMapping
// //     public ResponseEntity<?> listFarms(Authentication authentication) {
// //         return ResponseEntity.ok(
// //                 farmService.getFarmsByUser(authentication.getName())
// //         );
// //     }

// //     // GET /farms/{farmId} – get farm details
// //     @GetMapping("/{farmId}")
// //     public ResponseEntity<?> getFarm(@PathVariable Long farmId) {
// //         return ResponseEntity.ok(
// //                 farmService.getFarmById(farmId)
// //         );
// //     }
// // }


package com.example.demo.controller.farms;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody FarmRequest req) {

        Farm farm = new Farm();
        farm.setName(req.getName());
        farm.setSoilPH(req.getSoilPH());
        farm.setWaterLevel(req.getWaterLevel());
        farm.setSeason(req.getSeason());

        return ResponseEntity.ok(farmService.createFarm(farm));
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        return ResponseEntity.ok(farmService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
        return ResponseEntity.ok(farmService.getById(id));
    }
}

