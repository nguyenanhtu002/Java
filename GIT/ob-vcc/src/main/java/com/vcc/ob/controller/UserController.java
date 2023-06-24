package com.vcc.ob.controller;

import com.vcc.ob.data.dto.request.TransactionMoneyRequestDTO;
import com.vcc.ob.data.dto.request.UserRequestDTO;
import com.vcc.ob.data.dto.request.UserSearchRequestDTO;
import com.vcc.ob.data.dto.response.BaseResponse;
import com.vcc.ob.data.entity.User;
import com.vcc.ob.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createUser(@RequestBody @Validated UserRequestDTO userRequestDTO)
            throws SQLException {
        return new ResponseEntity<>(userService.createUser(userRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{user_id}/delete")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable(name = "user_id") String userId)
            throws SQLException {
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{user_id}/update")
    public ResponseEntity<BaseResponse> updateUser(@RequestBody @Validated UserRequestDTO userRequestDTO,
                                                   @PathVariable(name = "user_id") String userId)
            throws SQLException {
        return new ResponseEntity<>(userService.updateUser(userRequestDTO, userId), HttpStatus.OK);
    }

    @GetMapping(params = "user_id")
    public ResponseEntity<BaseResponse> getUserBayUserId(@RequestParam(name = "user_id") String userId)
            throws SQLException {
        return new ResponseEntity<>(userService.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> searchUser(@RequestParam(name = "name", required = false) String name,
                                                   @RequestParam(name = "address", required = false) String address,
                                                   @RequestParam(name = "page_number", required = false, defaultValue = "1") int pageNumber,
                                                   @RequestParam(name = "page_size", required = false, defaultValue = "20") int pageSize)
            throws SQLException {
        return new ResponseEntity<>(userService.searchUser(name, address, pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/fill-data-test")
    public ResponseEntity<BaseResponse> createUsers() throws SQLException {
        return new ResponseEntity<>(userService.createUsers(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> getUsersByUserId(@RequestBody UserSearchRequestDTO userSearchRequestDTO)
            throws SQLException {
        return new ResponseEntity<>(userService.getUsersByUserId(userSearchRequestDTO), HttpStatus.OK);
    }


    @PostMapping("/transaction-money")
    public ResponseEntity<BaseResponse> transactionMoney(@RequestBody TransactionMoneyRequestDTO transactionMoneyRequestDTO)
            throws SQLException {
        return new ResponseEntity<>(userService.transactionMoney(transactionMoneyRequestDTO), HttpStatus.OK);
    }
}


/**
 * Connection pool
 */