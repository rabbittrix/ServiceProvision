package com.jrsf.sales;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Profile("NIF")
public @interface NIF {

    /*
As regras para a validação do NIF são:

Tem de ter 9 dígitos;
O primeiro dígito tem de ser 1, 2, 5, 6, 8 ou 9; (Esta é a informação que circula na maior parte dos fóruns da internet, mas a realidade é que o 3 está reservado para uso de particulares assim que os começados por 2 se esgotarem e o 4 e 7 são utilizados em casos especiais, pelo que, por omissão, a nossa função ignora esta validação)
O dígito de controlo (último digíto do NIF) é obtido da seguinte forma:
9*d1 + 8*d2 + 7*d3 + 6*d4 + 5*d5 + 4*d6 + 3*d7 + 2*d8 + 1*d9  (em que d1 a d9 são os 9 dígitos do NIF);
Esta soma tem de ser múltiplo de 11 (quando divídida por 11 dar 0);
Subtraír o resto da divisão da soma por 11 a 11;
Se o resultado for 10, é assumído o algarismo 0;
[in webdados]

try
                {
                    final int max=9;
                    if (!nif.matches("[0-9]+") || nif.length()!=max) return false;
                    int checkSum=0;
                    //calcula a soma de controlo
                    for (int i=0; i<max-1; i++){
                        checkSum+=(nif.charAt(i)-'0')*(max-i);
                    }
                    int checkDigit=11-(checkSum % 11);
                    if (checkDigit>=10) checkDigit=0;
                    return checkDigit==nif.charAt(max-1)-'0';
                }
                catch (Exception e)
                {
                    return false;
                }
                finally
                {
                }

*/

}
