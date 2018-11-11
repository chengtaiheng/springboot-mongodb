package springboot.mongodb.application.controller;

import com.github.yingzhuo.carnival.json.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.mongodb.application.dao.BackupGDao;
import springboot.mongodb.application.domain.BackupG;

/**
 * @author: 程泰恒
 * @date: 2018/11/8 16:28
 */

@Slf4j
@RestController
@RequestMapping("springboot-mongodb")
public class SpringbootMongodbController {

    @Autowired
    private BackupGDao backupGDao;

    /**
     * 保存一个后备
     *
     * @param backupG 要保存的后备
     * @return 保存结果
     */
    @PostMapping("/save")
    private Json saveBackupG(BackupG backupG) {
        log.debug("backupG={}", backupG);
        backupGDao.saveGirl(backupG);
        return Json.instance()
                .payload("result", "successfully saved");
    }

    /**
     * 通过一个名字查询一个后备
     *
     * @param name 后备名字
     * @return 查询结果
     */
    @GetMapping("/find-one")
    public Json getOneByName(@RequestParam("name") String name) {

        log.debug("name={}", name);
        BackupG thatGirl = backupGDao.findBackupGByGirlName(name);
        return Json.instance()
                .payload("thatgirl", thatGirl);
    }

    /**
     * 通过对象的id跟新一个后备
     *
     * @param backupG 要跟新的对象
     * @return 跟新结果
     */
    @PostMapping("/update-one")
    public Json updateOneById(BackupG backupG) {
        log.debug("backupG={}", backupG);
        backupGDao.updateBackupG(backupG);
        return Json.instance()
                .payload("result", "update successfully");
    }

    /**
     * 通过一个id删除对象
     *
     * @param backupGId 要删除对象的id
     * @return 删除的结果
     */
    @PostMapping("/delete-one")
    public Json deleteOneById(@RequestParam("backupGId") Long backupGId) {
        log.debug("backupId={}", backupGId);
        backupGDao.deleteBacupGById(backupGId);
        return Json.instance()
                .payload("result", "successfully delete");
    }


}
