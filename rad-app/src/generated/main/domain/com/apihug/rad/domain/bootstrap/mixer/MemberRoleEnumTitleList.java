// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.tenant.MemberRoleEnum;
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
public class MemberRoleEnumTitleList extends ArrayList<MemberRoleEnum> {
  public static MemberRoleEnumTitleList EMPTY = new MemberRoleEnumTitleList() {
    @Override
    public boolean add(MemberRoleEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public MemberRoleEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, MemberRoleEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends MemberRoleEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends MemberRoleEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<MemberRoleEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super MemberRoleEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public MemberRoleEnumTitleList() {
    super();
  }

  public MemberRoleEnumTitleList(Collection<MemberRoleEnum> given) {
    super(given);
  }

  public List<MemberRoleEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static MemberRoleEnumTitleList from(List<MemberRoleEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new MemberRoleEnumTitleList(given);
    }
  }

  public static MemberRoleEnumTitleList from(MemberRoleEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new MemberRoleEnumTitleList(Arrays.asList(given));
    }
  }
}
