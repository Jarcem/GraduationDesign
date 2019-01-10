package org.jarcem.Services;

import org.jarcem.Beans.ScoreInfoBean;

import java.util.List;

public interface ScoreInfoBeanServices {
    public List<ScoreInfoBean> getAllScoreInfo();
    public List<ScoreInfoBean> getAllScoreInfos(String param);
    public List<ScoreInfoBean> getPersonScoreInfos(String param);
    public ScoreInfoBean getScoreInfo(String sco_id);
    public int addScoreInfo(ScoreInfoBean scoreInfoBean);
    public int deleteScoreInfo(String sco_id);
    public int updateScoreInfo(ScoreInfoBean scoreInfoBean);
    public int checkRepeat(String uid, String cid);
}
