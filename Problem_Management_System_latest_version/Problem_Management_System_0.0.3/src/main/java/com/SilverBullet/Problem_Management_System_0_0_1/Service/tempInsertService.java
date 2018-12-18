package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by delltest on 2017/5/21.
 */
@Service
public class tempInsertService {
    @Autowired
    private mapper mp;
    public Boolean tempInsert(ProblemInfo p) throws Exception {
        try {
            if (mp.tempIdSelect(p.getPid()) == p.getPid()) {
                return false;
            } else {
                mp.tempInsert(p);
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
