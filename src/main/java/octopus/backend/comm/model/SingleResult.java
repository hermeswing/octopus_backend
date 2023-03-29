package octopus.backend.comm.model;

import lombok.Getter;
import lombok.Setter;
import octopus.entity.CommonResult;

@Getter
@Setter
public class SingleResult<T> extends CommonResult {
	private T data;
}