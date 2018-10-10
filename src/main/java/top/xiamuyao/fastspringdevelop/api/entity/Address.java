package top.xiamuyao.fastspringdevelop.api.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("AddressId")
    private Integer AddressId;

    @TableField("PersonId")
    private Integer PersonId;

    @TableField("City")
    private String City;

    @TableField("State")
    private String State;

    private Date time;

    private Address(Builder builder) {
        setAddressId(builder.AddressId);
        setPersonId(builder.PersonId);
        setCity(builder.City);
        setState(builder.State);
        setTime(builder.time);
    }


    public static final class Builder {
        private Integer AddressId;
        private Integer PersonId;
        private String City;
        private String State;
        private Date time;

        public Builder() {
        }

        public Builder AddressId(Integer val) {
            AddressId = val;
            return this;
        }

        public Builder PersonId(Integer val) {
            PersonId = val;
            return this;
        }

        public Builder City(String val) {
            City = val;
            return this;
        }

        public Builder State(String val) {
            State = val;
            return this;
        }

        public Builder time(Date val) {
            time = val;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
