# room-type-crud-operations
## Implement Pagination, Transaction and Bean Validation
### steps to create project


- create project using spring initializr([url](https://start.spring.io/))

- select maven

- select spring boot version

- select java version

- project metadata(
  group(com.sunglowsys),
  artifact(room-type-crud-operation),
  package name(com.sunglowsys)
  )

- select packaging(jar)

- add dependency(spring web, spring data jpa, mysql driver)

- Generate jar file

- Extract the generated file

- open intelliJ IDEA(or any IDEA)

- load the project 

- create sub packages(
  domain,
  repository,
  service,
  rest
  )

- inside domain package create Hotel domain class and use @Entity annotation on this class

- In Hotel class define all the required properties of Hotel

- inside repository package create HotelRepository interface extending JpaRepository and use @Repository annotation on this interface 

- inside service package create HotelService interface

- In HotelService interface create method
```
   save(RoomType roomType);
   update(RoomType roomType);
   findAll(Pagable pagable);
   findById(Long id);
   delete(Long id);
```

- inside service package create HotelServiceImpl class implements HotelService and use @Service annotation on this class

- In HotelServiceImpl class implement all the methods of HotelService interface
### service method for pagination
```
 @Override
  public Page<RoomType> findAll(Pageable pageable) {
          log.debug("Request to find RoomType : {}", pageable.toString());
          return roomTypeRepository.findAll(pageable);
  }
```

- Inside rest HotelResource class and use @RestController annotation on this class,

- in this class create all the endPoints(methods)-

``` 
      @PostMapping()
      createHotel(){}
      
      @PutMapping()
      udateHotel(){}
      
      @GetMapping()
      getAllHotels(){}
      
      @GetMapping()
      getHotel(){}
      
      @DeleteMapping()
      deleteHotel(){}
```
### endPoint for Pagination 
````java
  @GetMapping("/room-types")
    public ResponseEntity<List<RoomType>> getAllRoomTypes(Pageable pageable) {
        log.debug("REST request to get RoomTypes : {}", pageable.toString());
        Page<RoomType> result = roomTypeService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }
