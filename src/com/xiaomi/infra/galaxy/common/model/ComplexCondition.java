package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexCondition
{
  private List<ComplexCondition> complexConditions;
  private List<Condition> conditions;
  private String operator;

  public ComplexCondition addComplexCondition(ComplexCondition paramComplexCondition)
  {
    if (this.complexConditions == null)
      this.complexConditions = new ArrayList();
    this.complexConditions.add(paramComplexCondition);
    return this;
  }

  public ComplexCondition addCondition(Condition paramCondition)
  {
    if (this.conditions == null)
      this.conditions = new ArrayList();
    this.conditions.add(paramCondition);
    return this;
  }

  public void check(CollisionCheckStack<ComplexCondition> paramCollisionCheckStack)
  {
    Operator.fromValue(this.operator);
    if (this.conditions != null)
    {
      Iterator localIterator2 = this.conditions.iterator();
      while (localIterator2.hasNext())
        ((Condition)localIterator2.next()).validate();
    }
    if (paramCollisionCheckStack == null)
      paramCollisionCheckStack = new CollisionCheckStack();
    if (paramCollisionCheckStack.push(this))
      throw new GalaxyClientException(ReturnCode.CONDITION_CYCLE_REFERENCE, "cycle in marshaller, " + paramCollisionCheckStack.getCycleString());
    if (this.complexConditions != null)
    {
      Iterator localIterator1 = this.complexConditions.iterator();
      while (localIterator1.hasNext())
        ((ComplexCondition)localIterator1.next()).check(paramCollisionCheckStack);
    }
  }

  public List<ComplexCondition> getComplexConditions()
  {
    return this.complexConditions;
  }

  public List<Condition> getConditions()
  {
    return this.conditions;
  }

  public String getOperator()
  {
    return this.operator;
  }

  public void setComplexConditions(List<ComplexCondition> paramList)
  {
    this.complexConditions = paramList;
  }

  public void setConditions(List<Condition> paramList)
  {
    this.conditions = paramList;
  }

  public void setOperator(String paramString)
  {
    this.operator = paramString;
  }

  public ComplexCondition withComplexConditions(List<ComplexCondition> paramList)
  {
    setComplexConditions(paramList);
    return this;
  }

  public ComplexCondition withConditions(List<Condition> paramList)
  {
    setConditions(paramList);
    return this;
  }

  public ComplexCondition withOperator(Operator paramOperator)
  {
    setOperator(paramOperator.name());
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.ComplexCondition
 * JD-Core Version:    0.6.2
 */