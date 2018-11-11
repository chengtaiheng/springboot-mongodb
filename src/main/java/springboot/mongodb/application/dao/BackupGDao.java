package springboot.mongodb.application.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import springboot.mongodb.application.domain.BackupG;

/**
 * @author: 程泰恒
 * @date: 2018/11/8 15:37
 */
@Slf4j
@Component
public class BackupGDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param backupG 后备
     */
    public void saveGirl(BackupG backupG) {
        log.debug("backupG={}", backupG);
        mongoTemplate.save(backupG);
    }

    /**
     * 根据用户名查询对象
     *
     * @param girlName 用户名
     */
    public BackupG findBackupGByGirlName(String girlName) {
        Query query = new Query(Criteria.where("name").is(girlName));
        BackupG girl = mongoTemplate.findOne(query, BackupG.class);
        return girl;
    }

    /**
     * 更新对象
     *
     * @param g 跟新对象
     */
    public void updateBackupG(BackupG g) {
        Query query = new Query(Criteria.where("id").is(g.getId()));
        Update update = new Update().set("name", g.getName())
                .set("character", g.getCharacter())
                .set("chest", g.getChest())
                .set("waist", g.getWaist())
                .set("hips", g.getHips());
        //跟新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, BackupG.class);
        //跟新查询返回结果集的所有
        mongoTemplate.updateMulti(query, update, BackupG.class);
    }

    /**
     * 删除对象
     *
     * @param id 要删除的对象的id
     */
    public void deleteBacupGById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, BackupG.class);
    }
}
