package com.example.blog.demos.web.controller;
//
import com.example.blog.demos.web.Dao.UserRepository;
import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.UserBasicInformation;
import com.example.blog.demos.web.untils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

//
//@RestController
//@RequestMapping("/user")
//public class loginController {
//    @Autowired
//    LoginServiceImpl loginService;
//@PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> login ( @RequestBody User user){
//    System.out.println(user);
//           Long username= user.getUserId();
//           String password=user.getUserPassword();
//           boolean isValidUser= loginService.isValidUser(username,password);
//           if(isValidUser){
//               String token= loginService.generateToken(String.valueOf(username));
//               Map<String,Object> result=new HashMap<>();
//               result.put("code",0);
//               result.put("token",token);
//               return ResponseEntity.ok(result);
//           }else {
//
//               Map<String,Object> result=new HashMap<>();
//               result.put("code",1);
//
//               return ResponseEntity.ok(result);
//           }
//}
//}
//@RestController
//@RequestMapping("/loginVerification")
//public class LoginVerificationController {
//    private static final int SUCCESS_CODE = 0;
//    private static final int ERROR_PASSWORD_CODE = 1;
//    private static final int ERROR_VERIFICATION_CODE = 2;
//    private static final int OTHER_ERROR_CODE = 3;
//
//    @Autowired
//    private LoginServiceImpl loginService;
//
//    @PostMapping
//    public ResponseEntity<Map<String, Object>> loginVerification(@RequestBody Map<Integer, String> request) {
//        Integer userId = Integer.valueOf(request.get("userID"));
//        String password = request.get("password");
//        String loginToken = request.get("loginToken");
//
//        boolean isValidUser = loginService.isValidUser(userId, password);
//        if (!isValidUser) {
//            Map<String, Object> response = new HashMap<>();
//            response.put("code", ERROR_PASSWORD_CODE);
//            return ResponseEntity.ok(response);
//        }
////
////        boolean isVerificationValid = loginService.(loginToken);
////        if (!isVerificationValid) {
////            Map<String, Object> response = new HashMap<>();
////            response.put("code", ERROR_VERIFICATION_CODE);
////            return ResponseEntity.ok(response);
////        }
//
//        String token = loginService.generateToken(userId);
//        if (token == null) {
//            Map<String, Object> response = new HashMap<>();
//            response.put("code", OTHER_ERROR_CODE);
//            return ResponseEntity.ok(response);
//        }
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("code", SUCCESS_CODE);
//        response.put("token", token);
//        return ResponseEntity.ok(response);
//    }
//}
@RestController
@CrossOrigin(origins = "*")
public class LoginVerificationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/loginVerification")
    public ResponseEntity<Map<String, Object>> loginVerification(@RequestBody Map<String, String> loginInfo) throws NoSuchAlgorithmException {
        // 获取请求参数
        Long userId = Long.valueOf(loginInfo.get("userId"));
        String passWord = loginInfo.get("passWord");


        // 查询用户信息
        UserBasicInformation user = userRepository.findByUserId(userId);

        // 判断用户是否存在
        if (user == null) {
            // 用户不存在，返回错误码3
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("code", 3);
            return ResponseEntity.status(HttpStatus.OK).body(errorMap);
        }

        // 判断密码是否正确
        if (!passWord.equals(user.getUserPassword())) {
            // 密码不正确，返回错误码1
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("code", 1);
            return ResponseEntity.status(HttpStatus.OK).body(errorMap);
        }

        // 登录成功，生成token并返回
        String token = TokenUtils.generateToken(user.getUserId());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        resultMap.put("token", token);
        return ResponseEntity.status(HttpStatus.OK).body(resultMap);
    }


}

