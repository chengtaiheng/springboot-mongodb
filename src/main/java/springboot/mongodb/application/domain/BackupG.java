package springboot.mongodb.application.domain;

import lombok.*;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author: 程泰恒
 * @date: 2018/11/8 13:51
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BackupG implements Serializable {

    private static final long serialVersionUID = 5124556595541134642L;

    /**
     * ID
     */
    private long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 兴趣
     */
    private String interests;

    /**
     * 性格
     */
    private String character;

    /**
     * 第一围度
     */
    private String chest;

    /**
     *  第二围度
     */
    private int waist;

    /**
     * 第三围度
     */
    private int hips;

    /**
     * 表观层
     */
    private int stars;
}
