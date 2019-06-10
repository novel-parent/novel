package bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class PageBean {
	private int totalpagenum;
	private int currengPagenum;
	private Object PageList;
	private int perPageSize;
}