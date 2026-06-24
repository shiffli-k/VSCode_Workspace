package com.sprlearn.learningspring.learn.concepts.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String Foo;
    private String Bar;
    private String FooBar;
}
