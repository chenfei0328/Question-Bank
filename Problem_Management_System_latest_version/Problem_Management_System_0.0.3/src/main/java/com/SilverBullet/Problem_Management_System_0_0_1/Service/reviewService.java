package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;

import java.util.List;

/**
 * Created by delltest on 2017/5/21.
 */
@Service
public class reviewService {
    @Autowired
    private mapper mp;
    public List<ProblemInfo> getTempInfo() {
        // TODO Auto-generated method stub
        List<ProblemInfo> tempInfo = mp.getAllTemp();
        return tempInfo;
    }
}
