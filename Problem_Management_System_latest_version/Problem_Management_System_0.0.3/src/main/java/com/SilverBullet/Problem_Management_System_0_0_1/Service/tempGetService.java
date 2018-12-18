package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by delltest on 2017/5/21.
 */
@Service
public class tempGetService {
    @Autowired
    private mapper mp;
    public ProblemInfo tempGet(String pid) throws Exception {
        try {
            List<ProblemInfo> Listp = mp.getTemp(pid);
            ProblemInfo p = Listp.get(0);
            return p;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
