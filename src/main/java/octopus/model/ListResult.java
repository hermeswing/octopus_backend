package octopus.model;

import lombok.Getter;
import lombok.Setter;
import octopus.entity.CommonResult;

import java.util.List;

@Getter
@Setter
public class ListResult<T> extends CommonResult {
    private List<T> list;
}
