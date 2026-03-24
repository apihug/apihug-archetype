// @formatter:off
package com.apihug.rad.api.customer;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;
import javax.annotation.Generated;

/**
 * 搜索客户请求
 */
@Generated("H.O.P.E. Infra Team")
@ProtoFrom(
    value = "com/apihug/rad/api/customer/api.proto",
    entity = "SearchCustomersRequest",
    kind = Kind.MESSAGE
)
public class SearchCustomersRequest {
  private static final long serialVersionUID = 0L;

  protected String keyword;

  protected CustomerStatusEnum status;

  public String getKeyword() {
    return keyword;
  }

  public SearchCustomersRequest setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  public CustomerStatusEnum getStatus() {
    return status;
  }

  public SearchCustomersRequest setStatus(CustomerStatusEnum status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "SearchCustomersRequest[" , "]")
    	.add("keyword=" + keyword)
    	.add("status=" + status)
        .toString();
  }
}
