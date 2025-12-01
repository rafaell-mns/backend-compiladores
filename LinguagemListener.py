# Generated from Linguagem.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .LinguagemParser import LinguagemParser
else:
    from LinguagemParser import LinguagemParser

# This class defines a complete listener for a parse tree produced by LinguagemParser.
class LinguagemListener(ParseTreeListener):

    # Enter a parse tree produced by LinguagemParser#program.
    def enterProgram(self, ctx:LinguagemParser.ProgramContext):
        pass

    # Exit a parse tree produced by LinguagemParser#program.
    def exitProgram(self, ctx:LinguagemParser.ProgramContext):
        pass


    # Enter a parse tree produced by LinguagemParser#statement.
    def enterStatement(self, ctx:LinguagemParser.StatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#statement.
    def exitStatement(self, ctx:LinguagemParser.StatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#block.
    def enterBlock(self, ctx:LinguagemParser.BlockContext):
        pass

    # Exit a parse tree produced by LinguagemParser#block.
    def exitBlock(self, ctx:LinguagemParser.BlockContext):
        pass


    # Enter a parse tree produced by LinguagemParser#variableDeclaration.
    def enterVariableDeclaration(self, ctx:LinguagemParser.VariableDeclarationContext):
        pass

    # Exit a parse tree produced by LinguagemParser#variableDeclaration.
    def exitVariableDeclaration(self, ctx:LinguagemParser.VariableDeclarationContext):
        pass


    # Enter a parse tree produced by LinguagemParser#variableDeclarator.
    def enterVariableDeclarator(self, ctx:LinguagemParser.VariableDeclaratorContext):
        pass

    # Exit a parse tree produced by LinguagemParser#variableDeclarator.
    def exitVariableDeclarator(self, ctx:LinguagemParser.VariableDeclaratorContext):
        pass


    # Enter a parse tree produced by LinguagemParser#functionDeclaration.
    def enterFunctionDeclaration(self, ctx:LinguagemParser.FunctionDeclarationContext):
        pass

    # Exit a parse tree produced by LinguagemParser#functionDeclaration.
    def exitFunctionDeclaration(self, ctx:LinguagemParser.FunctionDeclarationContext):
        pass


    # Enter a parse tree produced by LinguagemParser#paramList.
    def enterParamList(self, ctx:LinguagemParser.ParamListContext):
        pass

    # Exit a parse tree produced by LinguagemParser#paramList.
    def exitParamList(self, ctx:LinguagemParser.ParamListContext):
        pass


    # Enter a parse tree produced by LinguagemParser#returnStatement.
    def enterReturnStatement(self, ctx:LinguagemParser.ReturnStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#returnStatement.
    def exitReturnStatement(self, ctx:LinguagemParser.ReturnStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#ifStatement.
    def enterIfStatement(self, ctx:LinguagemParser.IfStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#ifStatement.
    def exitIfStatement(self, ctx:LinguagemParser.IfStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#switchStatement.
    def enterSwitchStatement(self, ctx:LinguagemParser.SwitchStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#switchStatement.
    def exitSwitchStatement(self, ctx:LinguagemParser.SwitchStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#switchCase.
    def enterSwitchCase(self, ctx:LinguagemParser.SwitchCaseContext):
        pass

    # Exit a parse tree produced by LinguagemParser#switchCase.
    def exitSwitchCase(self, ctx:LinguagemParser.SwitchCaseContext):
        pass


    # Enter a parse tree produced by LinguagemParser#defaultCase.
    def enterDefaultCase(self, ctx:LinguagemParser.DefaultCaseContext):
        pass

    # Exit a parse tree produced by LinguagemParser#defaultCase.
    def exitDefaultCase(self, ctx:LinguagemParser.DefaultCaseContext):
        pass


    # Enter a parse tree produced by LinguagemParser#forStatement.
    def enterForStatement(self, ctx:LinguagemParser.ForStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#forStatement.
    def exitForStatement(self, ctx:LinguagemParser.ForStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#forInit.
    def enterForInit(self, ctx:LinguagemParser.ForInitContext):
        pass

    # Exit a parse tree produced by LinguagemParser#forInit.
    def exitForInit(self, ctx:LinguagemParser.ForInitContext):
        pass


    # Enter a parse tree produced by LinguagemParser#whileStatement.
    def enterWhileStatement(self, ctx:LinguagemParser.WhileStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#whileStatement.
    def exitWhileStatement(self, ctx:LinguagemParser.WhileStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#doWhileStatement.
    def enterDoWhileStatement(self, ctx:LinguagemParser.DoWhileStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#doWhileStatement.
    def exitDoWhileStatement(self, ctx:LinguagemParser.DoWhileStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#breakStatement.
    def enterBreakStatement(self, ctx:LinguagemParser.BreakStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#breakStatement.
    def exitBreakStatement(self, ctx:LinguagemParser.BreakStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#continueStatement.
    def enterContinueStatement(self, ctx:LinguagemParser.ContinueStatementContext):
        pass

    # Exit a parse tree produced by LinguagemParser#continueStatement.
    def exitContinueStatement(self, ctx:LinguagemParser.ContinueStatementContext):
        pass


    # Enter a parse tree produced by LinguagemParser#expression.
    def enterExpression(self, ctx:LinguagemParser.ExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#expression.
    def exitExpression(self, ctx:LinguagemParser.ExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#assignmentExpression.
    def enterAssignmentExpression(self, ctx:LinguagemParser.AssignmentExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#assignmentExpression.
    def exitAssignmentExpression(self, ctx:LinguagemParser.AssignmentExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#assignmentOperator.
    def enterAssignmentOperator(self, ctx:LinguagemParser.AssignmentOperatorContext):
        pass

    # Exit a parse tree produced by LinguagemParser#assignmentOperator.
    def exitAssignmentOperator(self, ctx:LinguagemParser.AssignmentOperatorContext):
        pass


    # Enter a parse tree produced by LinguagemParser#conditionalExpression.
    def enterConditionalExpression(self, ctx:LinguagemParser.ConditionalExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#conditionalExpression.
    def exitConditionalExpression(self, ctx:LinguagemParser.ConditionalExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#logicalOrExpression.
    def enterLogicalOrExpression(self, ctx:LinguagemParser.LogicalOrExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#logicalOrExpression.
    def exitLogicalOrExpression(self, ctx:LinguagemParser.LogicalOrExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#logicalAndExpression.
    def enterLogicalAndExpression(self, ctx:LinguagemParser.LogicalAndExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#logicalAndExpression.
    def exitLogicalAndExpression(self, ctx:LinguagemParser.LogicalAndExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#bitwiseOrExpression.
    def enterBitwiseOrExpression(self, ctx:LinguagemParser.BitwiseOrExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#bitwiseOrExpression.
    def exitBitwiseOrExpression(self, ctx:LinguagemParser.BitwiseOrExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#bitwiseXorExpression.
    def enterBitwiseXorExpression(self, ctx:LinguagemParser.BitwiseXorExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#bitwiseXorExpression.
    def exitBitwiseXorExpression(self, ctx:LinguagemParser.BitwiseXorExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#bitwiseAndExpression.
    def enterBitwiseAndExpression(self, ctx:LinguagemParser.BitwiseAndExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#bitwiseAndExpression.
    def exitBitwiseAndExpression(self, ctx:LinguagemParser.BitwiseAndExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#equalityExpression.
    def enterEqualityExpression(self, ctx:LinguagemParser.EqualityExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#equalityExpression.
    def exitEqualityExpression(self, ctx:LinguagemParser.EqualityExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#relationalExpression.
    def enterRelationalExpression(self, ctx:LinguagemParser.RelationalExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#relationalExpression.
    def exitRelationalExpression(self, ctx:LinguagemParser.RelationalExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#shiftExpression.
    def enterShiftExpression(self, ctx:LinguagemParser.ShiftExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#shiftExpression.
    def exitShiftExpression(self, ctx:LinguagemParser.ShiftExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#additiveExpression.
    def enterAdditiveExpression(self, ctx:LinguagemParser.AdditiveExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#additiveExpression.
    def exitAdditiveExpression(self, ctx:LinguagemParser.AdditiveExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#multiplicativeExpression.
    def enterMultiplicativeExpression(self, ctx:LinguagemParser.MultiplicativeExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#multiplicativeExpression.
    def exitMultiplicativeExpression(self, ctx:LinguagemParser.MultiplicativeExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#exponentExpression.
    def enterExponentExpression(self, ctx:LinguagemParser.ExponentExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#exponentExpression.
    def exitExponentExpression(self, ctx:LinguagemParser.ExponentExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#unaryExpression.
    def enterUnaryExpression(self, ctx:LinguagemParser.UnaryExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#unaryExpression.
    def exitUnaryExpression(self, ctx:LinguagemParser.UnaryExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#postfixExpression.
    def enterPostfixExpression(self, ctx:LinguagemParser.PostfixExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#postfixExpression.
    def exitPostfixExpression(self, ctx:LinguagemParser.PostfixExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#postfixOp.
    def enterPostfixOp(self, ctx:LinguagemParser.PostfixOpContext):
        pass

    # Exit a parse tree produced by LinguagemParser#postfixOp.
    def exitPostfixOp(self, ctx:LinguagemParser.PostfixOpContext):
        pass


    # Enter a parse tree produced by LinguagemParser#primaryExpression.
    def enterPrimaryExpression(self, ctx:LinguagemParser.PrimaryExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#primaryExpression.
    def exitPrimaryExpression(self, ctx:LinguagemParser.PrimaryExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#functionExpression.
    def enterFunctionExpression(self, ctx:LinguagemParser.FunctionExpressionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#functionExpression.
    def exitFunctionExpression(self, ctx:LinguagemParser.FunctionExpressionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#arrowFunction.
    def enterArrowFunction(self, ctx:LinguagemParser.ArrowFunctionContext):
        pass

    # Exit a parse tree produced by LinguagemParser#arrowFunction.
    def exitArrowFunction(self, ctx:LinguagemParser.ArrowFunctionContext):
        pass


    # Enter a parse tree produced by LinguagemParser#objectLiteral.
    def enterObjectLiteral(self, ctx:LinguagemParser.ObjectLiteralContext):
        pass

    # Exit a parse tree produced by LinguagemParser#objectLiteral.
    def exitObjectLiteral(self, ctx:LinguagemParser.ObjectLiteralContext):
        pass


    # Enter a parse tree produced by LinguagemParser#objProp.
    def enterObjProp(self, ctx:LinguagemParser.ObjPropContext):
        pass

    # Exit a parse tree produced by LinguagemParser#objProp.
    def exitObjProp(self, ctx:LinguagemParser.ObjPropContext):
        pass


    # Enter a parse tree produced by LinguagemParser#property.
    def enterProperty(self, ctx:LinguagemParser.PropertyContext):
        pass

    # Exit a parse tree produced by LinguagemParser#property.
    def exitProperty(self, ctx:LinguagemParser.PropertyContext):
        pass


    # Enter a parse tree produced by LinguagemParser#arrayLiteral.
    def enterArrayLiteral(self, ctx:LinguagemParser.ArrayLiteralContext):
        pass

    # Exit a parse tree produced by LinguagemParser#arrayLiteral.
    def exitArrayLiteral(self, ctx:LinguagemParser.ArrayLiteralContext):
        pass


    # Enter a parse tree produced by LinguagemParser#argList.
    def enterArgList(self, ctx:LinguagemParser.ArgListContext):
        pass

    # Exit a parse tree produced by LinguagemParser#argList.
    def exitArgList(self, ctx:LinguagemParser.ArgListContext):
        pass



del LinguagemParser