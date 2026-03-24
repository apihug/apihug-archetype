// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.tenant.MemberTypeEnum;
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
public class MemberTypeEnumTitleList extends ArrayList<MemberTypeEnum> {
  public static MemberTypeEnumTitleList EMPTY = new MemberTypeEnumTitleList() {
    @Override
    public boolean add(MemberTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public MemberTypeEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, MemberTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends MemberTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends MemberTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<MemberTypeEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super MemberTypeEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public MemberTypeEnumTitleList() {
    super();
  }

  public MemberTypeEnumTitleList(Collection<MemberTypeEnum> given) {
    super(given);
  }

  public List<MemberTypeEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static MemberTypeEnumTitleList from(List<MemberTypeEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new MemberTypeEnumTitleList(given);
    }
  }

  public static MemberTypeEnumTitleList from(MemberTypeEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new MemberTypeEnumTitleList(Arrays.asList(given));
    }
  }
}
