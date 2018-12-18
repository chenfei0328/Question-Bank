package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by delltest on 2017/5/21.
 */
@Service
public class tempDeleteService {
    @Autowired
    private mapper mp;
    public Boolean tempDelete(String pid) throws Exception {
        try {
            if (mp.tempIdSelect(pid) == pid) {
                return false;
            } else {
                mp.DeleteTemp(pid);
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
