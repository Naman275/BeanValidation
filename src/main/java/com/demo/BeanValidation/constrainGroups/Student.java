package com.demo.BeanValidation.constrainGroups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class,common.class})
public interface Student {
}
