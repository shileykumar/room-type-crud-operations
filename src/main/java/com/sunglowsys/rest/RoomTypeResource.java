package com.sunglowsys.rest;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.rest.util.BadRequestException;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomTypeResource {

    private final Logger log = LoggerFactory.getLogger(RoomTypeResource.class);

    private final RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping("/room-types")
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) throws URISyntaxException {
        log.debug("REST request to create RoomType : {}", roomType);
        if (roomType.getId() != null) {
            throw new BadRequestException("Id should be null in create api call");
        }
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity
                .created(new URI("/api/room-types/" + result.getId()))
                .body(result);
    }

    @PutMapping("/room-types")
    public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomType) throws URISyntaxException {
        log.debug("REST request to update RoomType : {}", roomType);
        if (roomType.getId() == null) {
            throw new BadRequestException("Id should not be null in update api call");
        }
        RoomType result = roomTypeService.update(roomType);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/room-types")
    public ResponseEntity<List<RoomType>> getAllRoomTypes(Pageable pageable) {
        log.debug("REST request to get RoomTypes : {}", pageable.toString());
        Page<RoomType> result = roomTypeService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/room-types/{id}")
    public ResponseEntity<RoomType> getRoomType(@PathVariable Long id) {
        log.debug("REST request to get RoomType : {} ", id);
        Optional<RoomType> result = roomTypeService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @DeleteMapping("/room-types/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable Long id) {
        roomTypeService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
