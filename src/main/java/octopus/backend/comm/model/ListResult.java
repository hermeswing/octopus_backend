package octopus.backend.comm.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import octopus.entity.CommonResult;

@Getter
@Setter
public class ListResult<T> extends CommonResult {
    private List<T> list;
    
    // private CollectionModel<T> collection;
}
