package kr.ac.hansung.cse.hellospringsecurity.service;

import kr.ac.hansung.cse.hellospringsecurity.entity.Role;
import kr.ac.hansung.cse.hellospringsecurity.entity.User;

import java.util.List;

public interface RegistrationService {

    /**
     * User 정보가 Role 정보를 가지고 있으면
     * 해당 정보를 바탕으로 실제 DB에 저장할 메소드
     */
    User createUser(User user, List<Role> userRoles);

    boolean checkEmailExists(String email); //이메일 중복 검증

    Role findByRolename(String rolename); //DB상에 있는 role인지
}