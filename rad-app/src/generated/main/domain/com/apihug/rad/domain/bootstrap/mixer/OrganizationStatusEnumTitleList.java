// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.organization.OrganizationStatusEnum;
import java.lang.Override;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import javax.annotation.Generated;

@Generated("H.O.P.E. Infra Team")
public class OrganizationStatusEnumTitleList extends ArrayList<OrganizationStatusEnum> {
  public static OrganizationStatusEnumTitleList EMPTY = new OrganizationStatusEnumTitleList() {
    @Override
    public boolean add(OrganizationStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public OrganizationStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, OrganizationStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends OrganizationStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends OrganizationStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<OrganizationStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super OrganizationStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public OrganizationStatusEnumTitleList() {
    super();
  }

  public OrganizationStatusEnumTitleList(Collection<OrganizationStatusEnum> given) {
    super(given);
  }

  public List<OrganizationStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static OrganizationStatusEnumTitleList from(List<OrganizationStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new OrganizationStatusEnumTitleList(given);
    }
  }

  public static OrganizationStatusEnumTitleList from(OrganizationStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new OrganizationStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
