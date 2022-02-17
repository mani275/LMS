package com.Library.demo.Repository;

import com.Library.demo.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserModel, Long> {

}
