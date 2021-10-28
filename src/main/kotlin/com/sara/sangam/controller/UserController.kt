package com.sara.sangam.controller

import com.sara.sangam.dto.UserProfileDto
import com.sara.sangam.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController {
    @Autowired
    private lateinit var service: UserService;

    @PostMapping
    fun createUser(@RequestBody userDto: UserProfileDto): ResponseEntity<UserProfileDto> {
        return ResponseEntity(service.createUser(userDto), HttpStatus.OK)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<UserProfileDto>> {
        return ResponseEntity(service.findAll(), HttpStatus.OK)
    }

    @PutMapping
    fun updateUser(@RequestBody userDto: UserProfileDto): ResponseEntity<UserProfileDto> {
        return ResponseEntity(service.updateUser(userDto), HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun findByUserId(@PathVariable("id") userId: Int): ResponseEntity<UserProfileDto> {
        return ResponseEntity(service.findByUserId(userId), HttpStatus.OK)
    }
    @DeleteMapping("{id}")
    fun deleteByUserId(@PathVariable("id") userId: Int): ResponseEntity<String> {
        return ResponseEntity(service.deleteByUserId(userId), HttpStatus.OK)
    }

}