grammar Eemo;

@header {
    package me.pennekamp.eemo.parser;
}


discussion
    :   conversation
    ;

conversation
    :   ConversationStart
        labeledLine*
        ConversationEnd
    ;

labeledLine
    :   label? (conversation | statement)
    ;

statement
    :   Increment
    |   Double
    |   Add
    |   Decrement
    |   Halve
    |   Sub
    |   Reset
    |   MoveToLeft
    |   MoveToRight
    |   MoveToRegister
    |   MoveToStack
    |   CopyToLeftStack
    |   Output
    |   Input
    |   ifPositive
    |   jump
    |   Nop
    ;

label
    :   Id
    ;

ifPositive
    :   IfPositive conversation
    ;

jump
    :   Jump Id
    ;

ConversationStart:      '(^-^)/';
ConversationEnd:        '\\(._.)';
Increment:              '(^-^)';
Double:                 '(^o^)';
Add:                    '(*-*)';
Decrement:              '(;-;)';
Halve:                  '(;o;)';
Sub:                    '(._.)';
Reset:                  '(^~^)';
MoveToLeft:             '(°-° )';
MoveToRight:            '( °-°)';
MoveToRegister:         '\\(^-^)/';
MoveToStack:            '(>-<)';
CopyToLeftStack:        '(° _° )';
Output:                 '(°o°)';
Input:                  '(o-o)';
IfPositive:             '(?-?)';
Jump:                   '(+-+)';
Nop:                    '(-_-)';

Id
    :   '(' ~(' ' | '(' | ')')+ ')'
    ;

Skip
    :   [ \t\n\r] -> skip
    ;