package com.sara.sangam.entity

import lombok.Data
import javax.persistence.*

@Data
@Table
@Entity(name = "user_profile")
class UserProfile : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Int = 0
    var name: String = ""
    var mobile: String = ""
    var emailId: String = ""
    var roleName: String = ""
    var active: Boolean = true
    var passwd: String = ""
    var forgetPasswdCode: String = ""
}