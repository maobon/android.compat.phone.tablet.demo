package com.xin.bob.fragmentbestpractice.mock;

import com.xin.bob.fragmentbestpractice.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bob on 2017/6/12.
 * generate some mock data
 */

public class MockDataUtils {

    private static final String DATA_CONTENT = "　  评选颁授“八一勋章”，是贯彻落实党中央、习主席关于功勋荣誉表彰决策指示，推进强国强军伟大事业的重要举措，饱含着习主席对军队的深切厚爱，对英模典型的高度褒奖，将极大提振军心士气、激发昂扬斗志，汇聚实现中国梦强军梦的强大正能量。此次评选颁授工作，以习主席系列重要讲话精神为根本遵循，聚焦备战打仗和直接为战斗力服务，注重先进性和代表性，重点选拔在促进战斗力生成提高、完成作战等重大任务、推进科技兴军、推动国防和军队现代化建设中作出杰出贡献、建立卓越功勋的英模典型。各级把组织评选作为深入推进政治建军、改革强军、依法治军，强化练兵备战的重要载体，采取提名推荐、资格审查、组织公示、全面考核、呈报审批的步骤组织实施，使评选过程成为深入学习英模事迹、激励官兵昂扬奋进的过程。";

    public static List<News> generate() {
        List<News> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new News("News Title ## " + i, DATA_CONTENT));
        }
        return list;
    }
}
