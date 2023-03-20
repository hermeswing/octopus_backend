package octopus.model;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import lombok.Getter;
import lombok.Setter;
import octopus.entity.CommonResult;

@Getter
@Setter
public class ListResult<T> extends CommonResult {
	private List<T> list;

	private CollectionModel<T> collection;
}
