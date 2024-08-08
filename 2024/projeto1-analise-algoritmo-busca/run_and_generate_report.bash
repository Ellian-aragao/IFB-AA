#!/bin/bash

number_of_reports=$1
path_doc=$(pwd)"/doc"
path_jfr=$path_doc/jfr
MAVEN_HOME=/home/ellian/.asdf/installs/maven/3.9.8
JAVA_HOME=/home/ellian/.asdf/installs/java/temurin-21.0.4+7.0.LTS

check_argument() {
  if [ -z "$number_of_reports" ]; then
    number_of_reports=5
    echo "Nenhum argumento submetido, por padrão serão gerados $number_of_reports relatórios"
  else
    number_regex='^[0-9]+$'
    if ! [[ $number_of_reports =~ $number_regex ]]; then
      echo "Erro: argumento precisa ser um número inteiro positivo" >&2
      exit 1
    fi
  fi
}

check_reports_path() {
  if [ ! -d "$path_doc" ]; then
    echo "Não foi encontrado a pasta doc, criando pasta para documentos e relatórios"
    mkdir "$path_doc"
    mkdir "$path_jfr"
  fi


  if [ ! -d "$path_jfr" ]; then
    echo "Não foi encontrado a pasta jfr dentro de doc, criando pasta para relatórios"
    mkdir "$path_jfr"
  fi
}

build_project() {
  echo "Iniciando compilação do projeto"
  $MAVEN_HOME/bin/mvn clean package -T2C
  echo "Projeto compilado com êxito"
}

run_project_iteration() {
  iteration=$1
  file_report_name=$path_jfr/jfr_$(date "+%Y-%m-%dT%H:%M:%S").jfr
  java_runner_command="$JAVA_HOME/bin/java -Xms8G -Xmx16G -XX:StartFlightRecording=duration=3600s,filename=$file_report_name -jar target/projeto1-analise-algoritmo-busca-1.0-SNAPSHOT.jar"
  echo "Gerando relatório $iteration"
  echo "Rodando comando: sudo nice -n -20 $java_runner_command"
  sudo nice -n -20 $java_runner_command
  echo "Relatório $iteration concluído"
}

run_project() {
  echo "Rodando projeto para geração dos relatórios"
  for iteration in $(seq "$number_of_reports"); do
    run_project_iteration "$iteration"
  done
#  sudo chmod 666 "$path_jfr/*"
}

check_argument
check_reports_path
build_project
run_project

echo "Execução do projeto concluída"
