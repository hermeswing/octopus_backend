package octopus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteria {
	private String searchKey;
	private String searchOperation;
	private Object searchValue;
}
